import socket
def server_program():
    host = socket.gethostname()
    port = 5000
    ipdict= {"192.168.10.10":"FF.CC.DD.11", "192.168.10.1":"CC.FF.11.22", "192.168.0.1" :"DD.11.2.2" , "192.168.1.120":"AA.1.1.1"}
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
