def messageList(message):
    if not message:
        return "Message is Empty!"
    if len(message) <= 160:
        return message

    msgs_map = {}
    message_words = message.split()
    current_message = ''
    current_message_number = 1
    for word in message_words:
        if len(current_message + ' ' + word) > 154:
            msgs_map[current_message_number] = current_message
            current_message = word
            current_message_number += 1
        else:
            current_message += word + ' '

    n = len(msgs_map)
    messages = []
    for k in msgs_map:
        messages.append(msgs_map[k] + ' (' + str(k) + '/' + str(n) + ')')
    return messages

if __name__ == '__main__':
    T = int(input())
    for _ in range(T):
        message = input()
        print(messageList(message))