package DesignPatterns.Behavioral.Memento.article;

import java.util.ArrayList;
import java.util.List;

public class ArticleCareTaker {

    List<ArticleMemento> states;

    public ArticleCareTaker(){
        states = new ArrayList<>();
    }

    public ArticleMemento getByIndex(int i){
        return states.get(i);
    }

   public void saveState(ArticleMemento articleMemento){
        states.add(articleMemento);
    }

    public ArticleMemento getPreviousState(){
        if(states.size()>0)
         return states.get(states.size()-1);
        else
            return null;
    }
}
