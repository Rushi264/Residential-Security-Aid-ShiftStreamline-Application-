@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
        .withUser("admin")
        .password("{noop}pass") // {noop} for plain text, usually you would encode this
        .roles("USER");
        
}
