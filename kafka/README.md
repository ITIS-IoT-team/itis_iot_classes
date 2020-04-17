# Тестовый проект Spring Boot + Kafka

Kafka и Zookeeper поднимаются в докере. Команда:
```
 docker-compose -f kafka-dockers/docker-compose.yaml up
```
В контейнере создается 2 топика: topic1, topic2.
Еще один топик topic3 с тремя партициями задается в коде (класс com.configs.KafkaKonfig)
