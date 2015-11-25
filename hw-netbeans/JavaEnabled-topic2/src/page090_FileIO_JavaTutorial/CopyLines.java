/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * Uses buffered I/O to copy a data file, one line at a time.
 * Characters are grouped into a line in a buffer.
 * Buffered-I/O streams read/write from/to a buffer in memory.
 *
 * http://download.oracle.com/javase/tutorial/essential/io/charstreams.html
 */
public class CopyLines {

    public static void main(String[] args) {

        // These variables will point to the buffered character-stream objects.
        BufferedReader inputStream  = null;
        PrintWriter    outputStream = null;

        try {
            // Create the two buffered-I/O streams, using non-buffered streams.
            // (make sure you have the data file on C:)
            inputStream =
                new BufferedReader(new FileReader("c:\\data.txt"));
            outputStream =
                new PrintWriter(new FileWriter("c:\\line-data.txt"));

            // Store a line of characters here
            String line;

            // Read until end of file (null)
            while ((line = inputStream.readLine()) != null) {
                outputStream.println(line);
            }
        }
        catch(IOException e) {
            System.out.println("ERROR: " + e);
        }
        finally {
            // Close the files.
            // Code in a finally block is always executed.
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            }
            catch(IOException e) {
                System.out.println("ERROR: " + e);
            }
        }
    }
}

