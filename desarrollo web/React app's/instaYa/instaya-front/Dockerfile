FROM node:17-alpine

WORKDIR /app

COPY package.json .

RUN npm install

COPY . .

EXPOSE 9001
# required for docker desktop port mapping

CMD ["npm", "run", "dev"]