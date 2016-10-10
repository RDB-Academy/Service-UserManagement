package authenticator.repository;

import authenticator.form.LoginForm;
import com.google.inject.ImplementedBy;
import models.Profile;

import javax.annotation.Nullable;


@ImplementedBy(CredentialRepositoryImpl.class)
public interface CredentialRepository {
    @Nullable
    Profile authenticate(LoginForm loginForm);
}

