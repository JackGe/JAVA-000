package me.ty.week1;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author tge@wyze.com
 */


public class HelloClassLoader extends  ClassLoader {
	public static final String HELLO_XLASS = "xlass";

	/**
	 * Finds the class with the specified <a href="#name">binary name</a>.
	 * This method should be overridden by class loader implementations that
	 * follow the delegation model for loading classes, and will be invoked by
	 * the {@link #loadClass <tt>loadClass</tt>} method after checking the
	 * parent class loader for the requested class.  The default implementation
	 * throws a <tt>ClassNotFoundException</tt>.
	 *
	 * @param name The <a href="#name">binary name</a> of the class
	 * @return The resulting <tt>Class</tt> object
	 * @throws ClassNotFoundException If the class could not be found
	 * @since 1.2
	 */
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		// 未识别的的交给父加载器
		String fileName = String.format("%s.%s", name, HELLO_XLASS);
		String path = HelloClassLoader.class.getResource(fileName).getPath();
		System.out.println(path);
		try {
			byte[] dataByte = Files.readAllBytes(Paths.get(path));
			for (int i = 0; i < dataByte.length; i++) {
				dataByte[i] = (byte) ((byte)255 - dataByte[i]);
			}
			return defineClass(name, dataByte,0, dataByte.length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void main(String[] args) {

		try {
			Class<?> helloClassLoader = new HelloClassLoader().findClass("Hello");
			Class<?> hello = helloClassLoader.getClassLoader().loadClass("Hello");
			Method helloMethod = hello.getMethod("hello");
			helloMethod.invoke(hello.newInstance());
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
