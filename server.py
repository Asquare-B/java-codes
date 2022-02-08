import socket
def server_program():
    host = socket.gethostname()
    port = 4000
    ipdict= {"192.168.0.145":"AA.ED.BB.19", "192.168.103.1":"CA.FA.1.20", "192.168.7.101" :"DF.1.24.22" , "192.168.12.122":"AF.11.22.22"}
    server_socket = socket.socket()
    server_socket.bind((host, port))
    server_socket.listen(2)
    conn, address = server_socket.accept()
    print("Connection from: " + str(address))
    while True:
        data = conn.recv(1024).decode()
        if not data:
            break
        print("from connected user: Requesting MAC address of " + str(data))
        if(data in ipdict):
            data = ipdict[data]
        else:
            data = 'Not Found'
        conn.send(data.encode())
    conn.close()    
if __name__ == '__main__':
    server_program()
