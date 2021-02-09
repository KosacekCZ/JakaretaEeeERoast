package Res;

import Managers.PostManager;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("posts")
@Produces(MediaType.APPLICATION_JSON)
public class WhistlerAPI {

    @Inject
    private PostManager pm;

    @GET
    public Response getPosts() {
        return Response.ok(pm.getPost()).build();
    }

    @POST
    public Response addPost(Post post) {
        pm.addPost(post);
        return Response.ok("Posted.").build();
    }

    @PUT
    public Response editPost(@QueryParam("id") int id, Post post) {
        pm.editPost(post, id);
        return Response.ok().build();
    }

    @DELETE
    public Response deletePost(@QueryParam("id") int id) {
        pm.deletePost(id - 1);
        return Response.ok().build();
    }
}
