//https://dzone.com/articles/how-dependency-injection-di-works-in-spring-java-a
//Advantages of Dependency Injection
DI allows a client the flexibility of being configurable. Only client's behavior is fixed.
Testing can be performed using mock objects.
Loosely couple architecture.
DI advantages of high cohesion are:
Reduced module complexity
Increased system maintainability, because logic changes in the domain affect fewer modules.
Increased module reusability.
DI does not require any changes in code behavior it can be applied to legacy code as refactoring.
DI allows a client to remove all knowledge of a concrete implementation that needs to use. It is more reusable, more testable, more readable code.
DI makes it possible to eliminate, or at least reduce unnecessary dependencies.
DI allows concurrent or independent development.
DI decreases coupling between a class and its dependency.

Disadvantages of Dependency Injection
DI creates clients that demand configure details supplied by construction code.
DI can make code difficult to trace because it separates behavior from
construction; this means developers refer to more files to follow how a system performs.
DI can cause an explosion of types, especially in languages that
have explicit interface types like C# and Java.
DI can encourage dependence on DI framework.

Tight coupling :
A change in only one module usually forces a ripple effect of changes in
other modules.

Dependency Injection (DI)
1.Dependency Injection (DI) is a software design pattern that
implements inversion of control for resolving dependencies.

2.An injection is the passing of a dependency to a dependent object that would use it.

3.DI is a process whereby objects define their dependencies. The other objects they
work with�only through constructor arguments or arguments to a factory method or property�
are set on the object instance after it is constructed or returned from a factory method.

4.The container then injects those dependencies, and it creates the bean. This process
is named Inversion of Control (IoC) (the bean itself controls the instantiation or
location of its dependencies by using direct construction classes or a Service Locator).

5.DI refers to the process of supplying an external dependency to a software component.

Dependency Injection Performed Two Ways
1. Constructor-Based Dependency Injection
Constructor-based DI is when the container invokes a constructor with a
number of arguments, each of which represents a dependency or other class.

Calling a static factory method with particular arguments to construct the bean is
approximately equivalent, treating arguments to a constructor and to a static factory method.
The following example shows a class that can only be dependency-injected with constructor injection.
It is a POJO that has no dependencies on container specific interfaces, base classes, or annotations.
https://martinfowler.com/articles/injection.html
Naive Example:
class MovieLister{
	public Movie[] moviesDirectedBy(String arg) {
		List allMovies = finder.findAll();
		for (Iterator it = allMovies.iterator(); it.hasNext();) {
			Movie movie = (Movie) it.next();
			if (!movie.getDirector().equals(arg)) 
				it.remove();
		}
		return (Movie[]) allMovies.toArray(new Movie[allMovies.size()]);
	}
	public interface MovieFinder {
	    List findAll();
	}
}

class MovieLister{
	public MovieLister(
	MovieFinder finder) {
		this.finder = finder;       
	}
}