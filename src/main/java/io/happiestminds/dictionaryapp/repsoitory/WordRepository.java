package io.happiestminds.dictionaryapp.repsoitory;

import io.happiestminds.dictionaryapp.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends JpaRepository<Word,Long> {
    @Query("select count(wordId) from io.happiestminds.dictionaryapp.model.Word where  name=?1")
    int findWordCountByName(String name);

    Word findWordByName(String name);
}
