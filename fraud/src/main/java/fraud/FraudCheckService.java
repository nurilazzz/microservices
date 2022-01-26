package fraud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class FraudCheckService {

    private FraudCheckRepository fraudCheckRepository;

    @Autowired
    public FraudCheckService(FraudCheckRepository fraudCheckRepository) {
        this.fraudCheckRepository = fraudCheckRepository;
    }

    public boolean isFraudulentCustomer(Integer customerId) {
        fraudCheckRepository.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAt(LocalDate.now())
                        .build()
        );
        return false;
    }
}
