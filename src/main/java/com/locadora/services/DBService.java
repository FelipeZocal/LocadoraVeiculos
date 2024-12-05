package com.locadora.services;

import com.locadora.domains.Carro;
import com.locadora.domains.Cliente;
import com.locadora.domains.Locadora;
import com.locadora.domains.enums.Aprovacao;
import com.locadora.domains.enums.Conservacao;
import com.locadora.repositories.CarroRepository;
import com.locadora.repositories.ClienteRepository;
import com.locadora.repositories.LocadoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class DBService {

    @Autowired
    private ClienteRepository clienteRepo;

    @Autowired
    private LocadoraRepository locadoraRepo;

    @Autowired
    private CarroRepository carroRepo;

    public void initDB(){
        Locadora locadora1 = new Locadora(null,"Locadora1","CNPJ1","Rua São Paulo",111,0);
        Locadora locadora2 = new Locadora(null, "Locadora2", "CNPJ2", "Rua Bahia", 222, 4);

        Cliente cliente1 = new Cliente(null,"Cliente1","RG1","CPF1", LocalDate.now(),"Rua Pernambuco",1111,"Sem Histórico", locadora1, Aprovacao.APROVADO);
        Cliente cliente2 = new Cliente(null ,"Cliente2", "RG2", "CPF2", LocalDate.now(), "Rua Salvador", 2222, "Ativo", locadora2, Aprovacao.EMANALISE);

        Carro carro1 = new Carro(null,"BMW","X6","Branco",2020, new BigDecimal("350.50"),LocalDate.now(),"BMWX6",2500,4,"9999",locadora1, Conservacao.BOM);
        Carro carro2 = new Carro(null, "Corolla", "XLS", "Preto", 2017, new BigDecimal("157.90"), LocalDate.now(), "CRL2018", 24000, 4, "8888", locadora2, Conservacao.RAZOAVEL);

        locadoraRepo.save(locadora1);
        locadoraRepo.save(locadora2);

        clienteRepo.save(cliente1);
        clienteRepo.save(cliente2);

        carroRepo.save(carro1);
        carroRepo.save(carro2);
    }


}
