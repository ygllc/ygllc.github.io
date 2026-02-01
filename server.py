import http.server
import socketserver
import mimetypes
import os
import webbrowser
import sys

PythonPath = "C:\\Users\\User\\AppData\\Local\\Programs\\Python\\pythoncore-3.12-64\\python.exe"

# CONFIGURATION
PORT = 8080
# Path to your built app (relative to project root)
BUILD_DIR = "composeApp/build/dist/wasmJs/productionExecutable"

def run_server():
    # 1. Check if build exists
    if not os.path.exists(BUILD_DIR):
        print(f"❌ Error: Build folder not found at: {BUILD_DIR}")
        print("   Make sure to build the app first!")
        return

    # 2. Move into the build directory
    os.chdir(BUILD_DIR)

    # 3. Setup MIME types (Critical for WASM)
    mimetypes.init()
    mimetypes.add_type('application/wasm', '.wasm')
    mimetypes.add_type('application/javascript', '.js')

    # 4. Configure Server with No-Cache headers
    class Handler(http.server.SimpleHTTPRequestHandler):
        def end_headers(self):
            self.send_header('Cache-Control', 'no-store, no-cache, must-revalidate')
            self.send_header('Access-Control-Allow-Origin', '*')
            super().end_headers()

    # 5. Start Server and Open Browser
    print(f"✅ Serving WASM app at http://localhost:{PORT}")

    # Open browser automatically
    webbrowser.open(f"http://localhost:{PORT}")

    with socketserver.TCPServer(("", PORT), Handler) as httpd:
        try:
            httpd.serve_forever()
        except KeyboardInterrupt:
            print("\nStopping server...")
            sys.exit(0)

if __name__ == "__main__":
    run_server()