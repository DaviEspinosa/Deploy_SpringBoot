package br.com.davi.gamestore.Repository;

import org.springframework.data.repository.CrudRepository;

import br.com.davi.gamestore.Model.GameModel;

public interface GameRepository extends CrudRepository<GameModel, Integer> {
    
}
