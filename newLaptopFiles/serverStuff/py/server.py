from http.server import BaseHTTPRequestHandler, HTTPServer
from pathlib import Path

page = Path("page.html").read_text();
script = Path("script.html").read_text();
 
# HTTPRequestHandler class
class testHTTPServer_RequestHandler(BaseHTTPRequestHandler):
 
  # GET
  def do_GET(self):
        run();

        # Send response status code
        self.send_response(200)
 
        # Send page header
        self.send_header('Content-type','text/HTML');
        self.end_headers();
 
        # # Send page back to client
        # self.wfile.write(bytes(page, "utf8"));

        # # Send script back to client
        # self.wfile.write(bytes(script, "utf8"));

        return
 
def run():
  print('starting server...');
 
  # Server settings
  # Choose port 8080, for port 80, which is normally used for a http server, you need root access
  server_address = ('192.168.0.6', 8080);
  httpd = HTTPServer(server_address, testHTTPServer_RequestHandler);
  print('running server...');
  httpd.serve_forever();
 
 
run()