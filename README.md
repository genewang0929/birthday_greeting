# Birthday Greeting Kata

A project to get a greeting message to all members whose birthday is today via a **RESTful api**.

Each version has its own type of greeting message.

## Version 1: Simple Message

Subject: Happy birthday!  
Happy birthday, dear Robert!

### Example:
- Given: a set of member records above,  
- When: today is 8/8,  
- Then: we will get the **message below** when a RESTful api is invoked.

> Subject: Happy birthday!  
> Happy birthday, dear Robert!
> 
> Subject: Happy birthday!  
> Happy birthday, dear Sherry!

## Version 2: Tailer-made Message for different gender

__Male__:  
Subject: Happy birthday!  
Happy birthday, dear Robert!  
We offer special discount 20% off for the following items:  
White Wine, iPhone X

__Female__:  
Subject: Happy birthday!  
Happy birthday, dear Miki!  
We offer special discount 50% off for the following items:  
Cosmetic, LV Handbags

### Example:
- Given: a set of member records above,  
- When: today is 8/8,  
- Then: we will get the **message below** when a RESTful api is invoked.

> Subject: Happy birthday!  
> Happy birthday, dear Robert!  
> We offer special discount 20% off for the following items:  
> White Wine, iPhone X  
> 
> Subject: Happy birthday!  
> Happy birthday, dear Sherry!  
> We offer special discount 50% off for the following items:  
> Cosmetic, LV Handbags

## Version 3: Message with an Elder Picture for those whose age is over 49

Subject: Happy birthday!  
Happy birthday, dear Peter!  
([A greeting picture here](https://hr.jhu.edu/wp-content/uploads/elder-care-GettyImages-912073272.jpg))

## Version 4: Simple Message with full name

Subject: Happy birthday!  
Happy birthday, dear Yen, Robert!  
Subject: Happy birthday!  
Happy birthday, dear Chen, Sherry!

## Version 5: Simple Message but database changes

Subject: Happy birthday!  
Happy birthday, dear Robert!  
Subject: Happy birthday!  
Happy birthday, dear Sherry!

(Change database from **MongoDB** to **PostgreSQL**)

## Version 6: Simple Message but different output data format

Subject: Happy birthday!  
Happy birthday, dear Robert!

(Change output data format from **JSON** to **XML**)

### Example:

JSON:
> {  
> 	  "title": "Subject: Happy birthday!",  
> 	  "content": "Happy birthday, dear Robert!"  
> }

XML:
> <root>
	<title>Subject: Happy birthday!</title>
	<content>Happy birthday, dear Robert!</content>
</root>
