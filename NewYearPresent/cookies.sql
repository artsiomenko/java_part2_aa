DROP TABLE IF EXISTS "Sweets";
CREATE TABLE "Sweets" ("Name" TEXT, "Weight" INTEGER);
INSERT INTO "Sweets" VALUES('Aleshka',35);
INSERT INTO "Sweets" VALUES('Nuga',28);
DROP TABLE IF EXISTS "moz_cookies";
CREATE TABLE moz_cookies (id INTEGER PRIMARY KEY, baseDomain TEXT, appId INTEGER DEFAULT 0, inBrowserElement INTEGER DEFAULT 0, name TEXT, value TEXT, host TEXT, path TEXT, expiry INTEGER, lastAccessed INTEGER, creationTime INTEGER, isSecure INTEGER, isHttpOnly INTEGER, CONSTRAINT moz_uniqueid UNIQUE (name, host, path, appId, inBrowserElement));
INSERT INTO "moz_cookies" VALUES(1,'google.com',-2,0,'NID','74=Blz-Jr1eCXAQT6Kqbcs4UKSgfI6-CA0GWW-_G0Pgu9rZ4G50ieXnMdyzjSmICRX07_FJj8bbBppxFf_ckwqt5vsW8zx2ucq7cgxhN9t3_wit0lYQ_ZF82ZxK2VSFScoX','.google.com','/',1465658357,1449847157443000,1449847157443000,0,1);
CREATE INDEX moz_basedomain ON moz_cookies (baseDomain, appId, inBrowserElement);
