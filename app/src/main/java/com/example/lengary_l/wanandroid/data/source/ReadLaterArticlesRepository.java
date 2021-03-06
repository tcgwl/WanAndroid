package com.example.lengary_l.wanandroid.data.source;

import android.support.annotation.NonNull;

import com.example.lengary_l.wanandroid.data.ReadLaterArticleData;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by CoderLengary
 */


public class ReadLaterArticlesRepository implements ReadLaterArticlesDataSource {
    @NonNull
    private final ReadLaterArticlesDataSource localDataSource;

    @NonNull
    private static ReadLaterArticlesRepository INSTANCE;

    private ReadLaterArticlesRepository(@NonNull ReadLaterArticlesDataSource local) {
        this.localDataSource = local;
    }

    public static ReadLaterArticlesRepository getInstance(@NonNull ReadLaterArticlesDataSource local) {
        if (INSTANCE == null) {
            INSTANCE = new ReadLaterArticlesRepository(local);
        }
        return INSTANCE;
    }

    @Override
    public Observable<List<ReadLaterArticleData>> getReadLaterArticles(@NonNull int userId) {
        return localDataSource.getReadLaterArticles(userId);
    }

    @Override
    public void insertReadLaterArticle(@NonNull int userId, @NonNull int id, @NonNull long timeStamp){
        localDataSource.insertReadLaterArticle(userId, id, timeStamp);
    }

    @Override
    public void removeReadLaterArticle(@NonNull int userId, @NonNull int id) {
        localDataSource.removeReadLaterArticle(userId, id);
    }

    @Override
    public boolean isExist(@NonNull int userId, @NonNull int id) {
        return localDataSource.isExist(userId, id);
    }

    @Override
    public void clearAll() {
        localDataSource.clearAll();
    }
}
