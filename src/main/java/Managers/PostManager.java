package Managers;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import Res.Post;

@ApplicationScoped
public class PostManager {
    ArrayList <Post> postStorage =  new ArrayList<Post>();

        public ArrayList<Post> getPost() {
            return postStorage;
        }

        public void addPost(Post post) {
            post.setId(postStorage.size() + 1);
            postStorage.add(post);
        }

        public void editPost(Post post, int id) {
            postStorage.remove(id - 1);
            postStorage.add(id - 1, post);
            post.setId(id);
        }

        public void deletePost(int id) {
            postStorage.remove(id);
        }
}

