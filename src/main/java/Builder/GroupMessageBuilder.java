package Builder;

import Objects.GroupMessage;
import Objects.SaveHandle;

public class GroupMessageBuilder {

    public static GroupMessage getGroupMessageFromDatabase(int groupMessageID) {
        GroupMessage message = new GroupMessage();
        message.setID(new SaveHandle(groupMessageID));

        return message;
    }
}
