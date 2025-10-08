package Educative.Facebook.interfaces;

import Educative.Facebook.features.Page;

//Implemented by User
public interface PageFunctionsByUser {
    Page createPage(String name);
    Page sharePage(Page page);
    void likePage(Page page);
    void followPage(Page page);
    void unLikePage(Page page);
    void unFollowPage(Page page);
}
