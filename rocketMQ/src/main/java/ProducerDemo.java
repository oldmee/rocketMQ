/**
 * @Package PACKAGE_NAME
 * @Description: TODO
 * @author: R.lee
 * @date 2019/5/6 16:17
 */
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;

/**
 * 生产者范例
 */
public class ProducerDemo {

    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("mengzhidu-user");
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.start();

        for (int i = 0; i < 5; i ++) {
            Message message = new Message("user", "push", String.valueOf(i), new String("辛星-" + i).getBytes());
            SendResult result = producer.send(message);
            System.out.println("消息id为:  " + result.getMsgId() + "  发送状态为:" + result.getSendStatus());
        }

    }
}
