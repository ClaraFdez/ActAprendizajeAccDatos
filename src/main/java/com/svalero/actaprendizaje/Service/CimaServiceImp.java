package com.svalero.actaprendizaje.Service;

import com.svalero.actaprendizaje.Domain.Cima;
import com.svalero.actaprendizaje.Repository.CimaRepository;
import com.svalero.actaprendizaje.Utils.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CimaServiceImp implements CimaService{

    @Autowired
    private CimaRepository cimaRepository;


    @Override
    public Cima addCima(Cima cima) {
        return cimaRepository.save(cima);
    }

    @Override
    public List<Cima> findAll() {
        List<Cima> listaCimas;
        listaCimas = cimaRepository.findAll();
        return listaCimas;
    }

    @Override
    public Cima modifyCima(long id, Cima newCima) {
        Cima cima;
        cima = cimaRepository.findByIdCima(id)
                .orElseThrow(()-> new NotFoundException());
        newCima.setIdCima(id);
        return newCima;
    }

    @Override
    public void deleteCima(long id) {
        cimaRepository.deleteById(id);
    }

    @Override
    public Cima modidfyCimaVivac(long id, int vivac) {
        Cima cima;
        cima = cimaRepository.findByIdCima(id)
                .orElseThrow(()-> new NotFoundException());
        cima.setVivacs(vivac);
        return cimaRepository.save(cima);
    }

    @Override
    public Cima findById(long id) {
        Cima cima;
        cima = cimaRepository.findByIdCima(id)
                .orElseThrow(()-> new NotFoundException());
        return cima;
    }


}
