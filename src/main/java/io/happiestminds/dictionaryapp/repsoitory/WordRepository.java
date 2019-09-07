package io.happiestminds.dictionaryapp.repsoitory;

import io.happiestminds.dictionaryapp.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends JpaRepository<Word,Long> {
    @Query("select count(wordId) from io.happiestminds.dictionaryapp.model.Word where word=?1")
    int findWordCountByWord(String word);

    Word findWordByWord(String word);
}
