FROM node:22-slim AS builder
WORKDIR /app

COPY package.json ./
RUN npm install

# 환경변수 처리
# ARG VITE_BACKEND_URL
# ENV VITE_BACKEND_URL=http://localhost:8080

COPY ./ ./

RUN npm run build



FROM nginx:alpine

COPY --from=builder /app/dist /usr/share/nginx/html

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]