/*
*      _______                       _____   _____ _____  
*     |__   __|                     |  __ \ / ____|  __ \ 
*        | | __ _ _ __ ___  ___  ___| |  | | (___ | |__) |
*        | |/ _` | '__/ __|/ _ \/ __| |  | |\___ \|  ___/ 
*        | | (_| | |  \__ \ (_) \__ \ |__| |____) | |     
*        |_|\__,_|_|  |___/\___/|___/_____/|_____/|_|     
*                                                         
* -------------------------------------------------------------
*
* TarsosDSP is developed by Joren Six at IPEM, University Ghent
*  
* -------------------------------------------------------------
*
*  Info: http://0110.be/tag/TarsosDSP
*  Github: https://github.com/JorenSix/TarsosDSP
*  Releases: http://0110.be/releases/TarsosDSP/
*  
*  TarsosDSP includes modified source code by various authors,
*  for credits and info, see README.
* 
*/

package firstsample.mfcc_extractor.com.firstsample.DroidTarsosDSP.android;

import java.io.FileInputStream;
import java.io.IOException;

import firstsample.mfcc_extractor.com.firstsample.DroidTarsosDSP.core.io.TarsosDSPAudioFormat;
import firstsample.mfcc_extractor.com.firstsample.DroidTarsosDSP.core.io.TarsosDSPAudioInputStream;

public class AndroidFileInputStream implements TarsosDSPAudioInputStream {

	private final FileInputStream underlyingStream;
	private final TarsosDSPAudioFormat format;
	public AndroidFileInputStream(FileInputStream underlyingStream, TarsosDSPAudioFormat format){
		this.underlyingStream = underlyingStream;
		this.format = format;
	}

	@Override
	public long skip(long bytesToSkip) throws IOException {
		throw new IOException("Can not skip in audio stream");
	}

	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		return underlyingStream.read(b, off, len);
	}

	@Override
	public void close() throws IOException {
		underlyingStream.close();
	}

	@Override
	public TarsosDSPAudioFormat getFormat() {
		return format;
	}

	@Override
	public long getFrameLength() {
		return -1;
	}

}
