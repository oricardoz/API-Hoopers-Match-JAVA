package br.com.ricardo.HoopersMatch.Repositories;

import br.com.ricardo.HoopersMatch.Models.Arbitro;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class ArbitroRepository implements JpaRepository<Arbitro, Integer> {
    @Override
    public void flush() {

    }

    @Override
    public <S extends Arbitro> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Arbitro> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Arbitro> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Arbitro getOne(Integer integer) {
        return null;
    }

    @Override
    public Arbitro getById(Integer integer) {
        return null;
    }

    @Override
    public Arbitro getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Arbitro> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Arbitro> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Arbitro> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Arbitro> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Arbitro> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Arbitro> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Arbitro, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Arbitro> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Arbitro> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Arbitro> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Arbitro> findAll() {
        return List.of();
    }

    @Override
    public List<Arbitro> findAllById(Iterable<Integer> integers) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Arbitro entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Arbitro> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Arbitro> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Arbitro> findAll(Pageable pageable) {
        return null;
    }
}
