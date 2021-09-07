package com.Microservice.Learing.SpringCloudGateway;

import java.time.Duration;

import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;

@Configuration
public class SpringCloudGatewayConfig {
	@Bean
	public RouteLocator customRoutes(RouteLocatorBuilder builder) {

		return builder.routes().route(
				p -> p.path("/get").filters(f -> f.addRequestHeader("My.Header", "1234")).uri("http://httpbin.org:80"))
				.route(p -> p.path("/orderApi/**")

						.uri("lb://ORDER-SERVICE"))
				.route(p -> p.path("/PayTM/**")

						.uri("lb://PAYMENT-SERVICE"))
				.build();
	}

	/*
	 * @Bean public Customizer<Resilience4JCircuitBreakerFactory>
	 * globalCustomConfiguration() {
	 * 
	 * return factory -> factory.configureDefault(id -> new
	 * Resilience4JConfigBuilder(id)
	 * .timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.
	 * ofSeconds(5)).build())
	 * .circuitBreakerConfig(CircuitBreakerConfig.ofDefaults()).build()); }
	 * 
	 * @Bean public ReactiveResilience4JCircuitBreakerFactory factory() { return new
	 * ReactiveResilience4JCircuitBreakerFactory(); }
	 */

}
