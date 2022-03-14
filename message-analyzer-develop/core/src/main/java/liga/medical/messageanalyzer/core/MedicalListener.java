package liga.medical.messageanalyzer.core;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import liga.medical.DeviceIdentificationDto;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.util.SerializationUtils;

import java.util.logging.Logger;

@EnableRabbit
public class MedicalListener {
    private final static String QUEUE_NAME = "medical";
    static Logger log = Logger.getLogger(Logger.class.getName());

    @RabbitListener(queues = QUEUE_NAME)
    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();


        log.info(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            DeviceIdentificationDto dto = (DeviceIdentificationDto) SerializationUtils.deserialize(delivery.getBody());
            log.info(" [x] Received '" + dto.toString() + "'");
        };
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });
    }
}
