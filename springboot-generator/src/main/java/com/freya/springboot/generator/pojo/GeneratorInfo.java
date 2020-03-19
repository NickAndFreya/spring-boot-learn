package com.freya.springboot.generator.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeneratorInfo {

	private String tableName;

	private String codePath;

	private String packageParentPath;

	private String packagePath;

	private String keyStrategy;

	private String dtoName;

	private String controllerName;

	private String mapperName;

	private String mapperXmlName;

	private String serviceName;

	private String implName;

	private boolean dtoCreated;
	private boolean dtoCover;

	private boolean controllerCreated;
	private boolean controllerCover;

	private boolean mapperCreated;
	private boolean mapperCover;

	private boolean mapperXmlCreated;
	private boolean mapperXmlCover;

	private boolean serviceCreated;
	private boolean serviceCover;

	private boolean implCreated;
	private boolean implCover;

}
