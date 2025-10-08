package DesignPatterns.Behavioral.Memento.article;

public class Client {

    public static void main(String[] args) {

        ArticleCareTaker careTaker = new ArticleCareTaker();
        Article article = new Article(1, "My Article", "content1");
        article.setContent("ABC");    //original content
        System.out.println(article);

        ArticleMemento memento = article.createMemento(); //created immutable memento
        careTaker.saveState(memento);
        article.setContent("123");    //changed content
        System.out.println(article);

        ArticleMemento memento1 = article.createMemento();
        careTaker.saveState(memento1);

        ArticleMemento first_memento = careTaker.getByIndex(0);
        careTaker.saveState(first_memento);

        article.restore(first_memento);
        System.out.println(article);

        article.restore(memento);
        System.out.println(article);


    }
}
