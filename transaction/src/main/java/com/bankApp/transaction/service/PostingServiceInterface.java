package com.bankApp.transaction.service;

import com.bankApp.transaction.model.Transactions;
import com.bankApp.utils.Response;

public interface PostingServiceInterface {
    public Response postingService(Transactions transactions);
}
