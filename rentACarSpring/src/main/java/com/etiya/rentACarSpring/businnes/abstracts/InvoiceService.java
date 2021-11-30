package com.etiya.rentACarSpring.businnes.abstracts;

import java.sql.Date;
import java.util.List;

import com.etiya.rentACarSpring.businnes.dtos.InvoiceSearchListDto;
import com.etiya.rentACarSpring.businnes.request.InvoiceRequest.CreateInvoiceDateRequest;
import com.etiya.rentACarSpring.businnes.request.InvoiceRequest.CreateInvoiceRequest;
import com.etiya.rentACarSpring.businnes.request.InvoiceRequest.DeleteInvoiceRequest;
import com.etiya.rentACarSpring.businnes.request.InvoiceRequest.UpdateInvoiceRequest;
import com.etiya.rentACarSpring.core.utilities.results.DataResult;
import com.etiya.rentACarSpring.core.utilities.results.Result;
import com.etiya.rentACarSpring.entities.Invoice;
import com.etiya.rentACarSpring.entities.Rental;
import com.etiya.rentACarSpring.entities.complexTypes.CarDetailForColorAndBrand;

public interface InvoiceService {
	DataResult<List<InvoiceSearchListDto>> getAll();
	Result Add(CreateInvoiceRequest createRentalRequest);
	Result Update(UpdateInvoiceRequest updateInvoiceRequest);
	Result Delete(DeleteInvoiceRequest deleteInvoiceRequest);
	DataResult<List<InvoiceSearchListDto>> getInvoiceByDate(CreateInvoiceDateRequest createInvoiceDateRequest);
	DataResult<List<InvoiceSearchListDto>> getInvoiceByUserId(int userId);
}
