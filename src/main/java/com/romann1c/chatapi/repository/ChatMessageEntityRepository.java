package com.romann1c.chatapi.repository;

import com.romann1c.chatapi.entity.ChatMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ChatMessageEntityRepository extends JpaRepository<ChatMessageEntity, Long> {

    List<ChatMessageEntity> findAllBySenderIDAndReceiverID(Integer senderID, Integer receiverID);

}
