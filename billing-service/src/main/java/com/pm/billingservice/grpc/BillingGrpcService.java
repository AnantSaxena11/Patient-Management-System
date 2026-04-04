package com.pm.billingservice.grpc;


import billing.BillingResponse;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import billing.BillingServiceGrpc.BillingServiceImplBase;
@Slf4j
@GrpcService
public class BillingGrpcService extends BillingServiceImplBase {

    @Override
    public void createBillingAccount(billing.BillingRequest billingRequest ,
                                     StreamObserver<billing.BillingResponse> responseObserver){
        log.info("creating billing account request recieved {}", billingRequest.toString());

        //business logic eg save to db platform calculations etc

        // return a billingresponseobserver object and return it
        BillingResponse response = BillingResponse.newBuilder()
                .setAccountId("12345")
                .setStatus("ACTIVE")
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


}
