package com.qiscus.chat.ngobrel.ui.homepagetab.recentconversation;

import com.qiscus.chat.ngobrel.data.repository.ChatRoomRepository;
import com.qiscus.sdk.data.model.QiscusChatRoom;

import java.util.List;

/**
 * Created on : May 16, 2018
 * Author     : zetbaitsu
 * Name       : Zetra
 * GitHub     : https://github.com/zetbaitsu
 */
public class RecentConversationPresenter {
    private View view;
    private ChatRoomRepository chatRoomRepository;

    public RecentConversationPresenter(View view, ChatRoomRepository chatRoomRepository) {
        this.view = view;
        this.chatRoomRepository = chatRoomRepository;
    }

    public void loadChatRooms() {
        chatRoomRepository.getChatRooms(view::showChatRooms,
                throwable -> view.showErrorMessage(throwable.getMessage()));
    }

    public void openChatRoom(QiscusChatRoom chatRoom) {
        if (chatRoom.isGroup()) {
            view.showGroupChatRoomPage(chatRoom);
            return;
        }
        view.showChatRoomPage(chatRoom);
    }

    public interface View {
        void showChatRooms(List<QiscusChatRoom> chatRooms);

        void showChatRoomPage(QiscusChatRoom chatRoom);

        void showGroupChatRoomPage(QiscusChatRoom chatRoom);

        void showErrorMessage(String errorMessage);
    }
}