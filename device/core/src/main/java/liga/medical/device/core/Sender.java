package liga.medical.device.core;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import liga.medical.DeviceIdentificationDto;
import org.springframework.util.SerializationUtils;

import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.logging.Logger;

public class Sender {

    private final static String QUEUE_NAME = "medical";
    static Logger log = Logger.getLogger(Logger.class.getName());


    public static void main(String[] argv) throws Exception {

        // For test
        long deviceId = new Random().nextLong();
        long ownerId = new Random().nextLong();
        DeviceIdentificationDto dto = new DeviceIdentificationDto(deviceId, ownerId);


        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            channel.basicPublish("", QUEUE_NAME, null, SerializationUtils.serialize(dto));
            log.info(" [x] Sent '" + dto.toString() + "'");
        }
    }
}
