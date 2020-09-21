package com.cadastro.boot;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cadastro.boot.dao.PessoaDao;
import com.cadastro.boot.model.Person;


@RunWith(SpringRunner.class)
@DataJpaTest
public class PessoaRepositoryIntegrationTest {
	
 
    @Autowired
    private PessoaDao pessoaDao;
    
    @Test
    public void whenFindByName_thenReturnPessoa() {
        // given
        Person alex = new Person();
        alex.setName("Alex");
        LocalDate ldObj = LocalDate.of(2017, 11, 6);
        alex.setDataNascimento(ldObj);
        alex.setDataCadastro(ldObj);
        pessoaDao.save(alex);
     
        // when
        List<Person> found = pessoaDao.findAll();
     
        // then
        System.out.println(found.size());
        assertThat(found.size()).isEqualTo(1);
    }
 

}
