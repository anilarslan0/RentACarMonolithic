package com.etiya.rentACarSpring.businnes.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.rentACarSpring.businnes.abstracts.InvoiceService;
import com.etiya.rentACarSpring.businnes.constants.Messages;
import com.etiya.rentACarSpring.businnes.dtos.InvoiceSearchListDto;
import com.etiya.rentACarSpring.businnes.request.InvoiceRequest.CreateInvoiceRequest;
import com.etiya.rentACarSpring.businnes.request.InvoiceRequest.DeleteInvoiceRequest;
import com.etiya.rentACarSpring.businnes.request.InvoiceRequest.UpdateInvoiceRequest;
import com.etiya.rentACarSpring.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACarSpring.core.utilities.results.DataResult;
import com.etiya.rentACarSpring.core.utilities.results.Result;
import com.etiya.rentACarSpring.core.utilities.results.SuccesDataResult;
import com.etiya.rentACarSpring.core.utilities.results.SuccesResult;
import com.etiya.rentACarSpring.dataAccess.abstracts.InvoiceDao;
import com.etiya.rentACarSpring.entities.Invoice;

@Service
public class InvoiceManager implements InvoiceService {

	private InvoiceDao invoiceDao;
	private ModelMapperService modelMapperService;

	@Autowired
	public InvoiceManager(InvoiceDao invoiceDao, ModelMapperService modelMapperService) {
		super();
		this.invoiceDao = invoiceDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<InvoiceSearchListDto>> getAll() {
		List<Invoice> result = this.invoiceDao.findAll();
		List<InvoiceSearchListDto> response = result.stream()
				.map(invoice -> modelMapperService.forDto().map(invoice, InvoiceSearchListDto.class))
				.collect(Collectors.toList());

		return new SuccesDataResult<List<InvoiceSearchListDto>>(response);
	}

	@Override
	public Result Add(CreateInvoiceRequest createRentalRequest) {
		Invoice invoice = modelMapperService.forRequest().map(createRentalRequest, Invoice.class);
		this.invoiceDao.save(invoice);
		return new SuccesResult(Messages.addedInvoice);
	}

	@Override
	public Result Update(UpdateInvoiceRequest updateInvoiceRequest) {
		Invoice invoice = modelMapperService.forRequest().map(updateInvoiceRequest, Invoice.class);
		this.invoiceDao.save(invoice);
		return new SuccesResult(Messages.updateInvoice);
	}

	@Override
	public Result Delete(DeleteInvoiceRequest deleteInvoiceRequest) {
		this.invoiceDao.deleteById(deleteInvoiceRequest.getInvoiceId());
		return new SuccesResult(Messages.deleteInvoice);

	}

	

}
