package com.github.denisarruda.turista.ai;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

public class DocUtil {

	// metodo para filtrar apenas a extensao desejada
	public static PathMatcher glob(String glob) {
		return FileSystems.getDefault().getPathMatcher("glob:" + glob);
	}

	// metodo para recuperar o caminho dos documentos
	public static Path toPath(String relativePath) {
		try {
			URL fileUrl = DocUtil.class.getClassLoader().getResource(relativePath);
			return Paths.get(fileUrl.toURI());
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}
}
