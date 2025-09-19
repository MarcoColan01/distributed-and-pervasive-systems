package laboratorio_3;

import io.grpc.stub.StreamObserver;
import laboratorio3.SumServiceGrpc;
import laboratorio3.Sums;

public class SimpleSumImpl extends SumServiceGrpc.SumServiceImplBase {

    @Override
    public void simpleSum (Sums.SumRequest request, StreamObserver<Sums.SumResponse> responseObserver){
        System.out.println(request);
        Sums.SumResponse response = Sums.SumResponse.newBuilder().setSum(request.getN1()+ request.getN2()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
