package com.etiya.rentACarSpring.businnes.abstracts;

import java.util.List;

import com.etiya.rentACarSpring.businnes.dtos.InvoiceSearchListDto;
import com.etiya.rentACarSpring.businnes.request.InvoiceRequest.CreateInvoiceDateRequest;
import com.etiya.rentACarSpring.businnes.request.InvoiceRequest.DeleteInvoiceRequest;
import com.etiya.rentACarSpring.businnes.request.InvoiceRequest.UpdateInvoiceRequest;
import com.etiya.rentACarSpring.businnes.request.RentalRequest.DropOffCarRequest;
import com.etiya.rentACarSpring.core.utilities.results.DataResult;
import com.etiya.rentACarSpring.core.utilities.results.Result;

public interface InvoiceService {
	DataResult<List<InvoiceSearchListDto>> getAll();
	Result add(DropOffCarRequest dropOffCarRequest);
	Result update(UpdateInvoiceRequest updateInvoiceRequest);
	Result delete(DeleteInvoiceRequest deleteInvoiceRequest);
	DataResult<List<InvoiceSearchListDto>> getInvoiceByDate(CreateInvoiceDateRequest createInvoiceDateRequest);
	Integer rentOfTotalPrice(DropOffCarRequest dropOffCarRequest);
}
