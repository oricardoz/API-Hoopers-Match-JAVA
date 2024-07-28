package br.com.ricardo.HoopersMatch.Repositories;

import br.com.ricardo.HoopersMatch.Models.Jogadores;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class JogadoresRepository implements JpaRepository<Jogadores, Long> {
    @Override
    public void flush() {

    }

    @Override
    public <S extends Jogadores> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Jogadores> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Jogadores> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Jogadores getOne(Long aLong) {
        return null;
    }

    @Override
    public Jogadores getById(Long aLong) {
        return null;
    }

    @Override
    public Jogadores getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Jogadores> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Jogadores> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Jogadores> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Jogadores> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Jogadores> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Jogadores> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Jogadores, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Jogadores> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Jogadores> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Jogadores> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Jogadores> findAll() {
        return List.of();
    }

    @Override
    public List<Jogadores> findAllById(Iterable<Long> longs) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Jogadores entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Jogadores> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Jogadores> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Jogadores> findAll(Pageable pageable) {
        return null;
    }
}
