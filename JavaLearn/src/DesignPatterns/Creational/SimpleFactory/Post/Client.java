package DesignPatterns.Creational.SimpleFactory.Post;

public class Client {

	public static void main(String[] args) {
		Post newsPost = PostFactory.createPost("news");
		System.out.println(newsPost);

		Post productPost = PostFactory.createPost("product");
		System.out.println(productPost);

	}

}
