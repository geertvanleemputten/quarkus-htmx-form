package rest;

import io.quarkiverse.renarde.Controller;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import io.smallrye.common.annotation.Blocking;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import org.jboss.resteasy.reactive.RestForm;

@Blocking
public class AppFormComponent extends Controller {

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance view();
        public static native TemplateInstance view$subscriptionForm();
    }

    @GET
    public TemplateInstance load() {
        return Templates.view();
    }

    @GET
    public TemplateInstance subscribtionForm() {
        return Templates.view$subscriptionForm();
    }

    @POST
    public TemplateInstance subscribe(@RestForm @Email @NotBlank String email) {
        validation.addError("email", "Email is already taken");
        if (validation.hasErrors()) subscribtionForm();
        return Templates.view$subscriptionForm();
    }
}
