package com.javarush.task.Chat.task3008.client;

import com.javarush.task.Chat.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Alexander on 26.02.2018.
 */
public class BotClient extends Client {

    public class BotSocketThread extends SocketThread {
        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            if (message!=null && message.contains(": ")) {
                String[] params = message.split(": ");
                String userName = params[0];
                String text = params[1];
                SimpleDateFormat simpleDateFormat;
                switch (text) {
                    case "дата":
                        simpleDateFormat = new SimpleDateFormat("d.MM.YYYY");
                        break;
                    case "день":
                        simpleDateFormat =  new SimpleDateFormat("d");
                        break;
                    case "месяц":
                        simpleDateFormat =  new SimpleDateFormat("MMMM");
                        break;
                    case "год":
                        simpleDateFormat =  new SimpleDateFormat("YYYY");
                        break;
                    case "время":
                        simpleDateFormat =  new SimpleDateFormat("H:mm:ss");
                        break;
                    case "час":
                        simpleDateFormat =  new SimpleDateFormat("H");
                        break;
                    case "минуты":
                        simpleDateFormat =  new SimpleDateFormat("m");
                        break;
                    case "секунды":
                        simpleDateFormat =  new SimpleDateFormat("s");
                        break;
                    default:
                        simpleDateFormat = null;
                }
                if (simpleDateFormat!=null) {
                    sendTextMessage("Информация для " + userName + ": " + simpleDateFormat.format(Calendar.getInstance().getTime()));
                }
            }
        }

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {

        return String.format("date_bot_%d", (int) (Math.random()*100));
    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }
}
