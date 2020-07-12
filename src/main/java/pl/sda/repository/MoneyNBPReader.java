package pl.sda.repository;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
@Slf4j
@Repository
public class MoneyNBPReader {
    public MoneyNBPReader moneyNBPReader;

    public MoneyNBPReader(@Value("${myParam.key:no-key}") final String myParam) {
        log.info("myParam.key: [{}]",myParam);
    }
}
