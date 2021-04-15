package com.svalero.actaprendizaje.Service;

import com.svalero.actaprendizaje.Domain.Parque;
import com.svalero.actaprendizaje.Repository.ParqueRepository;
import com.svalero.actaprendizaje.Utils.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ParqueServiceImp implements ParqueService{

    @Autowired
    private ParqueRepository parqueRepository;


    @Override
    public Parque findByNombreParque(String nombre) {
        return parqueRepository.findByNombreParque(nombre);
    }


    @Override
    public List<Parque> findByAcceso(Boolean b) {
        return parqueRepository.findByAcceso(b);
    }


    @Override
    public Optional<Parque> findById(long id) {
        return parqueRepository.findById(id);
    }


    @Override
    public void delete(long id) {

        parqueRepository.deleteById(id);
    }


    @Override
    public Parque addParque(Parque parque) {
        return parqueRepository.save(parque);
    }


    @Override
    public Parque modifyParque(long id, Parque nuevoparque) {

        Parque parque = parqueRepository.findById(id)
                .orElseThrow(()->new NotFoundException());
        nuevoparque.setId(id);
        return parqueRepository.save(nuevoparque);
    }


    @Override
    public Parque modifyExtension(float extension, long idParque) {
        Parque parque = parqueRepository.findById(idParque)
                .orElseThrow(()-> new NotFoundException(idParque));
        parque.setExtParque(extension);
        return parqueRepository.save(parque);
    }


    @Override
    public Set<Parque> findAll() {
        return parqueRepository.findAll();
    }

}
