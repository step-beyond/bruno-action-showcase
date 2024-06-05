# bruno-action-showcase
This projects shows how to use StepBeyond's [bruno GitHub Action](https://github.com/step-beyond/bruno-action). Feel free to use this action to test your REST application with some custom http requests. The action uses the open source framework [bruno](https://www.usebruno.com/), which is basically a http client.   

# How to use bruno GitHub Action in your workflow file

1. Create **bruno test definitions** according to [bruno](https://docs.usebruno.com/bru-lang/samples#testing) or just take a look at our [sample definitions](./bruno/SampleBrunoCollection)
2. Start your application. We use a simple SpringBoot Application.
3. Wait until your application is healthy. We use curl, but you can use anything you like. Please consider, that the application must be up and healthy before you start bruno.
```yaml
      - name: Wait for service
        run: curl --retry-max-time 60 --retry 100 --retry-delay 1 --retry-connrefused -fail http://localhost:8080/api/actuator/health
```
4. Add our **GitHub Action** to your workflow files:
```yaml
      - name: Test Bruno 
        uses: step-beyond/bruno-action@1.0.14
        with:
          directory: ./bruno
          output-type: pr
```
5. For further information take a look at our documentation at [bruno GitHub action](https://github.com/step-beyond/bruno-action)

# Credits

Many thanks to all contributors from bruno!