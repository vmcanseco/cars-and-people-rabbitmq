package iuresti.training.peopleandcars;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {
    @Bean
    public Queue carQueue(){
        return new Queue("cars",false);

    }

    @Bean
    public Queue peopleQueue(){
        return new Queue("people",false);

    }

    @Bean
    public Queue carPeopleQueue(){
        return new Queue("carPeople",false);

    }

    @Bean
    public DirectExchange exchange(){
        return new DirectExchange("direct-exchange");
    }

    @Bean
    public Binding  carBinding(Queue carQueue,DirectExchange exchange){
        return BindingBuilder.bind(carQueue).to(exchange).with("car");
    }

    @Bean
    public Binding  peopleBinding(Queue peopleQueue,DirectExchange exchange){
        return BindingBuilder.bind(peopleQueue).to(exchange).with("people");
    }

    @Bean
    public Binding  carPeopleBinding(Queue carPeopleQueue,DirectExchange exchange){
        return BindingBuilder.bind(carPeopleQueue).to(exchange).with("car-people");
    }
}