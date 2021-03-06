package com.etiya.rentACarSpring.businnes.concretes;

import com.etiya.rentACarSpring.businnes.dtos.CorparateCustomerSearchListDto;
import com.etiya.rentACarSpring.core.utilities.adapter.findexScoreServiceAdapter.findexScoreService;
import com.etiya.rentACarSpring.core.utilities.businnessRules.BusinnessRules;
import com.etiya.rentACarSpring.core.utilities.results.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.rentACarSpring.businnes.abstracts.CorparateCustomerService;
import com.etiya.rentACarSpring.businnes.request.CorparateCustomerRequest.CreateCorparateRequest;
import com.etiya.rentACarSpring.businnes.request.CorparateCustomerRequest.DeleteCorparateRequest;
import com.etiya.rentACarSpring.businnes.request.CorparateCustomerRequest.UpdateCorparateRequest;
import com.etiya.rentACarSpring.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACarSpring.dataAccess.abstracts.CorparateCustomerDao;
import com.etiya.rentACarSpring.entities.CorparateCustomer;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CorparateCustomerManager implements CorparateCustomerService {

    private CorparateCustomerDao corparateCustomerDao;
    private ModelMapperService modelMapperService;
    private findexScoreService findexScoreService;

    @Autowired
    public CorparateCustomerManager(CorparateCustomerDao corparateCustomerDao, ModelMapperService modelMapperService
                    ,findexScoreService findexScoreService) {
        super();
        this.corparateCustomerDao = corparateCustomerDao;
        this.modelMapperService = modelMapperService;
        this.findexScoreService =findexScoreService;
    }

    @Override
    public DataResult<List<CorparateCustomerSearchListDto>> getAll() {
        List<CorparateCustomer> result = this.corparateCustomerDao.findAll();
        List<CorparateCustomerSearchListDto> response = result.stream()
                .map(corparateCustomer -> modelMapperService.forDto().map(corparateCustomer, CorparateCustomerSearchListDto.class))
                .collect(Collectors.toList());

        return new SuccesDataResult<List<CorparateCustomerSearchListDto>>(response);
    }

    @Override
    public Result add(CreateCorparateRequest createCorparateRequest) {
        Result result = BusinnessRules.run(checkIfTaxNumberExists(createCorparateRequest.getTaxNumber()));
        if (result != null) {
            return result;
        }

        CorparateCustomer corparateCustomer = modelMapperService.forRequest().map(createCorparateRequest, CorparateCustomer.class);
        corparateCustomer.setFindexScore(findexScoreService.getIndividualFindexScore(corparateCustomer.getTaxNumber()));
        this.corparateCustomerDao.save(corparateCustomer);
        return new SuccesResult("Ekleme ??slemi Basarili");
    }

    @Override
    public Result update(UpdateCorparateRequest updateCorparateRequest) {
        Result result = BusinnessRules.run(checkIfTaxNumberExists(updateCorparateRequest.getTaxNumber()));
        if (result != null) {
            return result;
        }

        CorparateCustomer corparateCustomer = modelMapperService.forRequest().map(updateCorparateRequest, CorparateCustomer.class);
        corparateCustomer.setFindexScore(findexScoreService.getIndividualFindexScore(corparateCustomer.getTaxNumber()));
        this.corparateCustomerDao.save(corparateCustomer);
        return new SuccesResult("G??ncelleme ????lemi Ba??ar??l??");
    }

    @Override
    public Result delete(DeleteCorparateRequest deleteCorparateRequest) {
        this.corparateCustomerDao.deleteById(deleteCorparateRequest.getCorparateCustomerId());
        return new SuccesResult("Silme ????lemi Ba??ar??l??");
    }

    private Result checkIfTaxNumberExists(String taxNumber) {

        if (this.corparateCustomerDao.existsByTaxNumber(taxNumber))
            return new ErrorResult("Vergi numaras?? sistemde kay??tl??d??r.");

        return new SuccesResult();
    }

}
