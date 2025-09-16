package Lesson2.Subscription;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class SubcriptionTest {
    @ParameterizedTest
    @ValueSource(strings = {"khanh", "khanh.tx@", "khanh tx@live.com", "khanh.tx@live com", "khanh.tx@gmail.com.cn.vn"})
    public void should_return_exception_after_subscribe_with_invalid_email(String email)
    {
        Subscription subscription = new Subscription();
        Exception ex = assertThrows(IllegalArgumentException.class, ()-> subscription.subscribe(email));
        assertThat(ex.getMessage(), equalTo("Email is invalid!"));
    }

    @Test
    public void should_return_true_after_subscribe_with_valid_email()
    {
        List<String> lstEmails = new ArrayList<>();
        //Arrange
        String email = "khanh.tx@live.com";
        ISubscriptionRepository repository = mock();
        IEmailRepository emailRepository = mock();
        when(repository.getSubscribers()).thenReturn(lstEmails);

        Subscription subscription = new Subscription(repository, emailRepository);
        Boolean result = subscription.subscribe(email);

        assertThat(result, is(true));
        assertThat(lstEmails, hasItem(email));
        verify(repository, times(1)).saveSubcribers(lstEmails);
        verify(emailRepository, times(1)).sendWelcomeEmail(email);
    }

    @Test
    public void should_return_false_for_email_already_subscribed()
    {
        List<String> lstEmails = new ArrayList<>();
        lstEmails.add("khanh.tx@live.com");
        lstEmails.add("txk2601@gmail.com");
        String email = "khanh.tx@live.com";

        ISubscriptionRepository repository = mock();
        IEmailRepository emailRepository = mock();
        when(repository.getSubscribers()).thenReturn(lstEmails);

        Subscription subscription = new Subscription(repository, emailRepository);
        Boolean result = subscription.subscribe(email);
        assertThat(result, is(false));
        verify(repository, times(0)).saveSubcribers(lstEmails);
        verify(emailRepository, times(0)).sendWelcomeEmail(email);    }
}
